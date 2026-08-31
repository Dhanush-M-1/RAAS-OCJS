#include <bits/stdc++.h>
int main() {
  int size, speed, length;
  scanf("%d %d %d", &size, &speed, &length);
  int seconds = 0;
  int a = size * length;
  int b = speed * length;
  while (a > b) {
    a -= speed;
    seconds++;
  }
  printf("%d", seconds);
}
