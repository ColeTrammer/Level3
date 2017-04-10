int BOXES_PER_SIDE = 4;
int BOX_SIZE = 100;
int BOX_SPACING = 7;
int MARGIN = 30;

void setup() {
 size(800, 800); 
 background(255, 255, 255);
}

void draw() {
  fill(0, 0, 0);
  noStroke();
  for (int row = 0; row < BOXES_PER_SIDE; row++) {
    for (int col = 0; col < BOXES_PER_SIDE; col++) {
      rect(row * BOX_SIZE + row * BOX_SPACING + MARGIN, col * BOX_SIZE + col * BOX_SPACING + MARGIN, BOX_SIZE, BOX_SIZE);
    }
  }
}