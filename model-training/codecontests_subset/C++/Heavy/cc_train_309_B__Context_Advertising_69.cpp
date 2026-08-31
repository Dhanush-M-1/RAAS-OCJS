#include <bits/stdc++.h>
using namespace std;
char s[5100000];
int sc[1000003][20];
int main() {
  int n, r, c;
  scanf("%d%d%d", &n, &r, &c);
  vector<int> v;
  vector<string> txt;
  while (scanf("%s", s) == 1) {
    v.push_back(strlen(s));
    txt.push_back((string)s);
  }
  assert(v.size() == n);
  vector<long long> sum(n + 1);
  for (int i = 0; i < v.size(); ++i) sum[i + 1] = sum[i] + v[i];
  int it = 0;
  for (int i = 0; i < n; ++i) {
    while (it <= n && sum[it] - sum[i] + it - i - 1 <= c) ++it;
    sc[i][0] = it - 1;
  }
  for (int i = 0; i < 20; ++i) sc[n][i] = n;
  for (int i = 1; i < 20; ++i)
    for (int j = 0; j < n; ++j) sc[j][i] = sc[sc[j][i - 1]][i - 1];
  int best = 0;
  long long ma = 0;
  for (int i = 0; i < n; ++i) {
    int pos = i;
    for (int pw = 0; pw < 20; ++pw)
      if (r & (1 << pw)) pos = sc[pos][pw];
    if (ma < pos - i) {
      best = i;
      ma = pos - i;
    }
  }
  for (int i = 0; i < r; ++i) {
    if (sc[best][0] == best) break;
    string out = "";
    for (int j = best; j < sc[best][0]; ++j) {
      out += txt[j];
      if (j + 1 < sc[best][0]) out += " ";
    }
    best = sc[best][0];
    printf("%s\n", out.c_str());
  }
  return 0;
}
