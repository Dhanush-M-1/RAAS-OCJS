#include <bits/stdc++.h>
using namespace std;
template <class T, class U>
istream &operator>>(istream &in, pair<T, U> &rhs) {
  in >> rhs.first;
  in >> rhs.second;
  return in;
}
template <class T, class U>
ostream &operator>>(ostream &out, const pair<T, U> &rhs) {
  out << rhs.first;
  out << " ";
  out << rhs.second;
  return out;
}
template <class T, class U>
pair<T, U> operator+(pair<T, U> &a, pair<T, U> &b) {
  return pair<T, U>(a.first + b.first, a.second + b.second);
}
template <class T, class U>
pair<T, U> operator-(pair<T, U> &a, pair<T, U> &b) {
  return pair<T, U>(a.first - b.first, a.second - b.second);
}
template <class T>
istream &operator>>(istream &in, vector<T> &a) {
  for (auto &i : a) cin >> i;
  return in;
}
template <class T>
ostream &operator<<(ostream &out, const vector<T> &a) {
  for (auto &i : a) cout << i << " ";
  return out;
}
template <class T>
ostream &operator<<(ostream &out, const set<T> &a) {
  for (auto &i : a) cout << i << " ";
  return out;
}
template <class T>
ostream &operator<<(ostream &out, const unordered_set<T> &a) {
  for (auto &i : a) cout << i << " ";
  return out;
}
template <class T>
ostream &operator<<(ostream &out, const multiset<T> &a) {
  for (auto &i : a) cout << i << " ";
  return out;
}
template <class T, class U>
ostream &operator<<(ostream &out, const map<T, U> &a) {
  for (auto &i : a) cout << "(" << i.first << ", " << i.second << ")\n";
  return out;
}
template <class T, class U>
ostream &operator<<(ostream &out, const unordered_map<T, U> &a) {
  for (auto &i : a) cout << "(" << i.first << ", " << i.second << ")\n";
  return out;
}
const long long int N = 1e5 + 100;
const long long int inf = 1e9;
const double pi = acos(-1);
void solve(int test_case) {
  long long int n, j = 0, l, r;
  cin >> n >> l >> r;
  long long int cur = 1, done = 0;
  if (l == n * (n - 1) + 1) {
    cout << 1 << "\n";
    return;
  }
  while (done + 2 * (n - cur) < l) {
    done += 2 * (n - cur);
    cur++;
  }
  long long int nxt = cur + 1;
  vector<long long int> ans;
  l -= done;
  while (done <= r) {
    ans.emplace_back(cur);
    done++;
    if (done > r) break;
    ans.emplace_back(nxt);
    nxt++;
    done++;
    if (nxt == n + 1) {
      cur++;
      nxt = cur + 1;
      if (cur == n && done <= r) {
        done++;
        ans.emplace_back(1);
      }
    }
  }
  for (int i = l - 1; i + 1 < ans.size(); ++i) cout << ans[i] << " ";
  cout << "\n";
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie();
  cout.tie();
  int t = 1;
  cin >> t;
  for (int i = 1; i < t + 1; i++) solve(i);
}
