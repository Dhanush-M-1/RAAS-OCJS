#include <bits/stdc++.h>
using namespace std;
int cnt[26];
int main() {
  int n;
  scanf("%d", &n);
  string x;
  cin >> x;
  for (int i = 0; i < x.length(); i++) {
    cnt[x[i] - 'A']++;
  }
  int A = cnt[0], F = cnt['F' - 'A'], I = cnt['I' - 'A'];
  int cnt = 0;
  for (int i = 0; i < x.length(); i++) {
    if (x[i] != 'F') {
      int tmp = A + F;
      if (x[i] == 'A' || x[i] == 'F') tmp--;
      if (tmp == n - 1) cnt++;
    }
  }
  printf("%d\n", cnt);
  return 0;
}
