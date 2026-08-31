#include <bits/stdc++.h>
using namespace std;
int d[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int pos[] = {0, 1, 3, 4, 6, 7, 8, 9};
map<string, int> m;
string parse(vector<char> v) {
  string ans = "";
  for (int i = 0; i < v.size(); i++) ans += v[i];
  return ans;
}
void valid(vector<char> v) {
  if (v.size() != 10) return;
  for (int i = 0; i < 8; i++) {
    if (v[pos[i]] < 48 || v[pos[i]] > 57) return;
  }
  if (v[2] != '-' || v[5] != '-') return;
  int month = (v[3] - 48) * 10 + v[4] - 48;
  int date = (v[0] - 48) * 10 + v[1] - 48;
  int year = (v[6] - 48) * 1000 + (v[7] - 48) * 100 + (v[8] - 48) * 10 +
             (v[9] - 48) * 1;
  if (year >= 2013 && year <= 2015 && month >= 1 && month <= 12 && date >= 1 &&
      date <= d[month]) {
    m[parse(v)]++;
  }
}
void pop_front(vector<char> &v) {
  if (!v.empty()) {
    v.erase(v.begin());
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  string s;
  cin >> s;
  vector<char> v;
  for (int i = 0; i < 10; i++) v.push_back(s[i]);
  valid(v);
  for (int i = 10; i < s.size(); i++) {
    pop_front(v);
    v.push_back(s[i]);
    valid(v);
  }
  string ans = "";
  int maxi = -1;
  for (auto it : m) {
    if (it.second > maxi) {
      maxi = it.second;
      ans = it.first;
    }
  }
  cout << ans << '\n';
}
