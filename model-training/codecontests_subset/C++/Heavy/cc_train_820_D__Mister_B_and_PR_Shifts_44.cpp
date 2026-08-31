#include <bits/stdc++.h>
using namespace std;
int n, p[1000010], a[1000010], addall, cnt0, cnt1, cnt2;
long long tmp;
vector<int> v[1000010];
bool flag[1000010];
int ask(int x) { return a[x] + addall; }
long long Abs(long long x) {
  if (x < 0) return -x;
  return x;
}
void dec(int n) {
  if (p[n] - ask(n) > 0)
    cnt1--;
  else if (p[n] - ask(n) == 0)
    cnt0--;
  else
    cnt2--;
  tmp -= cnt1;
  tmp += cnt2 + cnt0;
  tmp -= Abs(p[n] - ask(n));
  addall++;
  a[n] = 1 - addall;
  tmp += Abs(p[n] - ask(n));
  if (p[n] - ask(n) == 0)
    cnt0++;
  else
    cnt1++;
}
void add(int j, int v) {
  if (p[j] - ask(j) > 0)
    cnt1 += v;
  else if (p[j] - ask(j) == 0)
    cnt0 += v;
  else
    cnt2 += v;
}
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &p[i]);
    a[i] = i;
    if (p[i] > i) {
      cnt1++;
      tmp += p[i] - (long long)i;
      v[p[i] - i].push_back(i);
    } else if (p[i] == i) {
      cnt0++;
      v[0].push_back(i);
    } else if (p[i] < i) {
      cnt2++;
      tmp += i - (long long)p[i];
    }
    v[n - i].push_back(i);
    if (n - i + p[i] - 1 < n) v[n - i + p[i] - 1].push_back(i);
  }
  long long ans = tmp;
  int tk = 0;
  dec(n);
  for (int i = 0; i < v[0].size(); i++) {
    int j = v[0][i];
    if (j == n || flag[j]) continue;
    flag[j] = 1;
    addall--, add(j, -1);
    addall++, add(j, 1);
  }
  for (int i = 0; i < v[1].size(); i++) {
    int j = v[1][i];
    if (j == n || flag[j]) continue;
    flag[j] = 1;
    addall--, add(j, -1);
    addall++, add(j, 1);
  }
  for (int i = 0; i < v[0].size(); i++) flag[v[0][i]] = 0;
  for (int i = 0; i < v[1].size(); i++) flag[v[1][i]] = 0;
  for (int k = 1; k < n; k++) {
    if (tmp < ans) ans = tmp, tk = k;
    dec(n - k);
    for (int i = 0; i < v[k].size(); i++) {
      int j = v[k][i];
      if (j == n - k || flag[j]) continue;
      flag[j] = 1;
      addall--, add(j, -1);
      addall++, add(j, 1);
    }
    for (int i = 0; i < v[k + 1].size(); i++) {
      int j = v[k + 1][i];
      if (j == n - k || flag[j]) continue;
      flag[j] = 1;
      addall--, add(j, -1);
      addall++, add(j, 1);
    }
    for (int i = 0; i < v[k].size(); i++) flag[v[k][i]] = 0;
    for (int i = 0; i < v[k + 1].size(); i++) flag[v[k + 1][i]] = 0;
  }
  cout << ans << ' ' << tk << endl;
  return 0;
}
