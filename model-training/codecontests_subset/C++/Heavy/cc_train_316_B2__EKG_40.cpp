#include <bits/stdc++.h>
using namespace std;
#pragma comment(linker, "/STACK:100000000")
int mas[1111];
int obr[1111];
vector<int> lines;
int main() {
  int n, x;
  scanf("%d %d", &n, &x);
  for (int i = 1; i <= n; i++) scanf("%d", &mas[i]), obr[mas[i]] = i;
  int num = -1;
  int bobrlen = 0;
  int g = 0;
  for (int i = 1; i <= n; i++) {
    if (mas[i] == 0) {
      int len = 1;
      int v = i;
      int d = 0;
      if (v == x) num = (int)(lines).size(), g = d;
      while (obr[v] != 0) {
        d++;
        v = obr[v];
        if (v == x) num = (int)(lines).size(), g = d;
        len++;
      }
      lines.push_back(len);
    }
  }
  bobrlen = lines[num];
  swap(lines[num], lines[(int)(lines).size() - 1]);
  lines.pop_back();
  sort(lines.begin(), lines.end());
  bool can[11111];
  for (int i = 0; i < 11111; i++) can[i] = false;
  can[0] = true;
  for (int i = (int)(lines).size() - 1; i >= 0; i--) {
    for (int j = 1110; j >= 0; j--) {
      if (can[j]) {
        can[j + lines[i]] = true;
      }
    }
  }
  for (int i = 0; i < 11111; i++) {
    if (can[i]) {
      printf("%d\n", i + g + 1);
    }
  }
  return 0;
}
