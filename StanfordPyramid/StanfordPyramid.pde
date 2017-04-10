int BRICK_WIDTH = 30;
int BRICK_HEIGHT = 12;
int BRICKS_IN_BASE = 14;

void setup() {
  size(800, 400);
  background(255, 255, 255);
}

void draw() {
  int verticalOffset = height - BRICK_HEIGHT * BRICKS_IN_BASE;
  int horizontalOffset = (width - BRICK_WIDTH * BRICKS_IN_BASE) / 2;
  for (int bricks = BRICKS_IN_BASE; bricks > 0; bricks--) {
    for (int i = 0; i < bricks; i++) {
      rect(i * BRICK_WIDTH + (0.5 * BRICK_WIDTH * (BRICKS_IN_BASE - bricks)) + horizontalOffset, (bricks - 1) * BRICK_HEIGHT + verticalOffset, BRICK_WIDTH, BRICK_HEIGHT);
    }
  }
}