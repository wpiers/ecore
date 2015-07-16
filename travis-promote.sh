BINTRAY_USER=wpiers
BINTRAY_R=https://dl.bintray.com/$BINTRAY_USER/generic
BINTRAY_W=https://api.bintray.com/content/$BINTRAY_USER/generic

# clear last nightly products 
NIGHTLY_PATTERN=CloudDesigner.$VERSION.N
for file in $(curl --list-only --silent -u$BINTRAY_USER:$KEY $BINTRAY_R/ | grep 'href="#'$NIGHTLY_PATTERN | sed 's/.*href="#//' | sed 's/".*//');
do curl -u$BINTRAY_USER:$KEY -X DELETE $BINTRAY_W/$file
don

# clear last nightly update site
curl -u$BINTRAY_USER:$KEY -X DELETE $BINTRAY_W/CloudDesigner/$VERSION/artifacts.jar
curl -u$BINTRAY_USER:$KEY -X DELETE $BINTRAY_W/CloudDesigner/$VERSION/content.jar
for file in $(curl --list-only --silent -u$BINTRAY_USER:$KEY $BINTRAY_R/CloudDesigner/$VERSION/features/ | grep 'href="#' | sed 's/.*href="#//' | sed 's/".*//');
do curl -u$BINTRAY_USER:$KEY -X DELETE $BINTRAY_W/$file
don
for file in $(curl --list-only --silent -u$BINTRAY_USER:$KEY $BINTRAY_R/CloudDesigner/$VERSION/plugins/ | grep 'href="#' | sed 's/.*href="#//' | sed 's/".*//');
do curl -u$BINTRAY_USER:$KEY -X DELETE $BINTRAY_W/$file
don

# copy new products
VERSION_DIR=$BINTRAY_W/CloudDesigner/$VERSION
cd clouddesigner/org.occiware.clouddesigner.product/target/products
curl -T org.occiware.clouddesigner.product-linux.gtk.x86_64.zip -u$BINTRAY_USER:$KEY $VERSION_DIR/CloudDesigner.$VERSION.N$TRAVIS_BUILD_NUMBER.linux.gtk.x86_64.zip
curl -T org.occiware.clouddesigner.product-macosx.cocoa.x86_64.zip -u$BINTRAY_USER:$KEY $VERSION_DIR/CloudDesigner.$VERSION.N$TRAVIS_BUILD_NUMBER.macosx.cocoa.x86_64.zip
curl -T org.occiware.clouddesigner.product-win32.win32.x86.zip -u$BINTRAY_USER:$KEY $VERSION_DIR/CloudDesigner.$VERSION.N$TRAVIS_BUILD_NUMBER.win32.x86.zip

# copy new update site
cd ../../../org.occiware.clouddesigner.repository/target/repository
curl -T artifacts.jar -u$BINTRAY_USER:$KEY $VERSION_DIR/artifacts.jar
curl -T content.jar -u$BINTRAY_USER:$KEY $VERSION_DIR/content.jar
for file in $(features/*);
curl -T $file -u$BINTRAY_USER:$KEY $VERSION_DIR/$file
done
for file in $(plugins/*);
curl -T $file -u$BINTRAY_USER:$KEY $VERSION_DIR/$file
done

# publish nightly
curl -XPOST -u$BINTRAY_USER:$KEY $VERSION_DIR/publish
