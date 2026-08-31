#include <bits/stdc++.h>
using namespace std;
int a[10][10];
vector<int> ostv;
int perevod(int n, int p) {
  ostv.resize(1);
  int chastn = n / p;
  ostv[0] = n % p;
  int k = 1;
  while (chastn >= p) {
    k++;
    ostv.resize(k);
    ostv[k - 1] = chastn % p;
    chastn = chastn / p;
  }
  ostv.resize(k + 1);
  ostv[k] = chastn;
  int ans = 0, d = 1;
  for (int i = 0; i < ostv.size(); i++) {
    ans += ostv[i] * d;
    d = d * 10;
  }
  return ans;
}
int main() {
  int k, s;
  scanf("%d", &k);
  for (int i = 0; i < k - 1; i++) {
    a[0][i] = i + 1;
    a[i][0] = i + 1;
  }
  for (int i = 1; i < k - 1; i++)
    for (int j = 1; j < k - 1; j++) {
      s = (i + 1) * (j + 1);
      a[i][j] = perevod(s, k);
    }
  for (int i = 0; i < k - 1; i++) {
    for (int j = 0; j < k - 1; j++) printf("%d ", a[i][j]);
    printf("\n");
  }
  return 0;
}
