#include <bits/stdc++.h>
#pragma comment(linker, "/stack:200000000")
using namespace std;
void redirectIO() {
  ios::sync_with_stdio(false);
  cin.tie(0);
}
long long mVal[1100000];
long long upd[1100000];
long long s[210000];
void refr(int a) { mVal[a] = mVal[a * 2] + mVal[a * 2 + 1] + upd[a]; }
void push(int a) {
  mVal[a * 2] += upd[a];
  upd[a * 2] += upd[a];
  mVal[a * 2 + 1] += upd[a];
  upd[a * 2 + 1] += upd[a];
  upd[a] = 0;
}
void build(int a, int beg, int end) {
  if (beg == end) {
    mVal[a] = beg - 1;
    return;
  }
  build(a * 2, beg, (beg + end) / 2);
  build(a * 2 + 1, (beg + end) / 2 + 1, end);
  refr(a);
}
int targ_end;
int targ_beg;
long long targ_val;
void update(int a, int beg, int end) {
  if (beg > targ_end || end < targ_beg) return;
  if (beg >= targ_beg && end <= targ_end) {
    upd[a] += targ_val;
    mVal[a] += targ_val;
    return;
  }
  push(a);
  update(a * 2, beg, (beg + end) / 2);
  update(a * 2 + 1, (beg + end) / 2 + 1, end);
  refr(a);
}
int findIndex(int a, int beg, int end) {
  if (beg == end) {
    return beg;
  }
  push(a);
  if (mVal[a * 2] < targ_val) {
    targ_val -= mVal[a * 2];
    return findIndex(a * 2 + 1, (beg + end) / 2 + 1, end);
  }
  return findIndex(a * 2, beg, (beg + end) / 2);
}
int main() {
  redirectIO();
  int n;
  cin >> n;
  for (int i = 1; i <= (n); i++) cin >> s[i];
  build(1, 1, n);
  set<int> ss;
  for (int i = 1; i <= (n); i++) ss.insert(i);
  vector<int> answer;
  for (int i = n; i > 0; --i) {
    targ_val = s[i];
    int b = findIndex(1, 1, n);
    int a = *ss.lower_bound(b);
    ss.erase(a);
    answer.push_back(a);
    targ_beg = a + 1;
    targ_end = a + 1;
    targ_val = -a;
    update(1, 1, n);
  }
  reverse(answer.begin(), answer.end());
  for (int x : answer) cout << x << " ";
  return 0;
}
