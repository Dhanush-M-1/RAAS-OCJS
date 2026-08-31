#include<cstdio>
using namespace std;

int n;
int s[40];

int size(char *w) {
  int counter = 0;
  while (w[counter] != 0) counter++;
  return counter;
}

bool ok(int f, int s) {
  if (s <= 5) return true;
  if (f >= 5 && s <= 12) return true;
  if (f >= 12 && s <= 17) return true;
  if (f >= 17 && s <= 24) return true;
  if (f >= 24 && s <= 31) return true;
  return false;
}

int main() {
  while (1) {
    scanf("%d", &n);
    if (n == 0) break;
    for (int i = 0; i < n; i++) {
      char w[15];
      scanf("%s", w);
      s[i] = size(w);
    }
    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = i; j < n; j++) {
        if (!ok(sum, sum + s[j])) break;
        sum += s[j];
        if (sum == 31) break;
      }
      if (sum == 31) {
        printf("%d\n", i + 1);
        break;
      }
    }
  }
}

