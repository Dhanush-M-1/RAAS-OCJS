#include <bits/stdc++.h>
using namespace std;
void func(void) {
  freopen("input.c", "r", stdin);
  freopen("output.c", "w", stdout);
}
void print(vector<long long> &v) {
  cout << v.size() << endl;
  for (int i = 0; i < v.size(); i++) {
    printf("%lld ", v[i]);
  }
  printf("\n");
}
void print(vector<pair<long long, long long> > &v) {
  cout << v.size() << endl;
  for (int i = 0; i < v.size(); i++) {
    printf("%lld %lld\n", v[i].first, v[i].second);
  }
}
void print(double d) { cout << fixed << setprecision(10) << d << endl; }
void print(string s, double d) {
  cout << s << " ";
  cout << fixed << setprecision(10) << d << endl;
}
const int N = 2e5 + 100;
set<int> s[N];
set<pair<int, int> > keep;
int in[N];
vector<pair<int, int> > v;
int answer[N];
void setAnswer(int x, int i, int n) { answer[i] = x; }
void finIt(int n) {
  for (int i = 0; i < n; i++) {
    if (answer[i] == -1) answer[i] = 0;
  }
}
int getAnswer(int k) {
  while (keep.size()) {
    auto it = keep.begin();
    pair<int, int> x = *it;
    if (x.first >= k) break;
    int y = x.second;
    keep.erase(it);
    for (auto it1 = s[y].begin(); it1 != s[y].end(); it1++) {
      int z = *it1;
      keep.erase(keep.find({in[z], z}));
      in[z]--;
      keep.insert({in[z], z});
      s[z].erase(y);
    }
    s[y].clear();
  }
  return keep.size();
}
int main() {
  int n, q, i, j = 0, temp, t, k, ans = 0, sum = 0, x, y, z, cnt = 0, m, fg = 0,
               mx = 0, mx1 = 0;
  scanf("%d %d %d", &n, &m, &k);
  for (int i = 0; i < m; i++) {
    scanf("%d %d", &x, &y);
    s[x].insert(y);
    s[y].insert(x);
    v.push_back({x, y});
    in[x]++;
    in[y]++;
  }
  for (int i = 1; i <= n; i++) {
    keep.insert({in[i], i});
  }
  int nowAnswer = getAnswer(k);
  answer[m - 1] = nowAnswer;
  for (int i = v.size() - 1; i >= 1; i--) {
    int x = v[i].first;
    int y = v[i].second;
    if (s[x].find(y) == s[x].end()) {
      answer[i - 1] = nowAnswer;
      continue;
    }
    keep.erase(keep.find({in[x], x}));
    keep.erase(keep.find({in[y], y}));
    in[x]--;
    in[y]--;
    keep.insert({in[x], x});
    keep.insert({in[y], y});
    s[x].erase(y);
    s[y].erase(x);
    nowAnswer = getAnswer(k);
    answer[i - 1] = nowAnswer;
  }
  for (int i = 0; i < m; i++) {
    printf("%d\n", answer[i]);
  }
}
