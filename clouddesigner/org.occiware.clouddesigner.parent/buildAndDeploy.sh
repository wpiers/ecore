NIGHTLY_DIR=https://api.bintray.com/content/wpiers/generic/CloudDesigner/nightly

# build clouddesigner
mvn clean verify
cd ../org.occiware.clouddesigner.product/target/products

# clear last nightly
curl -v -uwpiers:$KEY $NIGHTLY_DIR -Q "DELE *"

# copy new artifacts
curl -T org.occiware.clouddesigner.product-linux.gtk.x86_64.zip -uwpiers:$KEY $NIGHTLY_DIR/CloudDesigner.linux.gtk.x86_64.zip
curl -T org.occiware.clouddesigner.product-macosx.cocoa.x86_64.zip -uwpiers:$KEY $NIGHTLY_DIR/CloudDesigner.macosx.cocoa.x86_64.zip
curl -T org.occiware.clouddesigner.product-win32.win32.x86.zip -uwpiers:$KEY $NIGHTLY_DIR/CloudDesigner.win32.x86.zip

# publish nightly
curl -XPOST -uwpiers:$KEY $NIGHTLY_DIR/publish
