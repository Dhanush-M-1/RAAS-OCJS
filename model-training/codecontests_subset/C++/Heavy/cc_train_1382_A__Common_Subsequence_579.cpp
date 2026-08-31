#include <bits/stdc++.h>
using namespace std;
template <typename T>
void dekhao(T val) {
  cout << "template val   is  == " << val << endl;
}
template <typename F, typename S>
ostream &operator<<(ostream &os, const pair<F, S> &p) {
  return os << "(" << p.first << ", " << p.second << ")";
}
template <typename T>
ostream &operator<<(ostream &os, const vector<T> &v) {
  os << "{";
  typename vector<T>::const_iterator it;
  for (it = v.begin(); it != v.end(); it++) {
    if (it != v.begin()) os << ", ";
    os << *it;
  }
  return os << "}";
}
template <typename T>
ostream &operator<<(ostream &os, const set<T> &v) {
  os << "[";
  typename set<T>::const_iterator it;
  for (it = v.begin(); it != v.end(); it++) {
    if (it != v.begin()) os << ", ";
    os << *it;
  }
  return os << "]";
}
template <typename F, typename S>
ostream &operator<<(ostream &os, const map<F, S> &v) {
  os << "[";
  typename map<F, S>::const_iterator it;
  for (it = v.begin(); it != v.end(); it++) {
    if (it != v.begin()) os << ", ";
    os << it->first << " = " << it->second;
  }
  return os << "]";
}
void Ekfile() {
  freopen("A1.in", "r", stdin);
  freopen("A1.out", "w", stdout);
}
int Tcase;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> Tcase;
  while (Tcase--) {
    long long int n, m, a[1100], b[1100];
    map<int, int> amap, bmap;
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
      cin >> a[i];
      amap[a[i]]++;
    }
    for (int i = 1; i <= m; i++) {
      cin >> b[i];
      bmap[b[i]]++;
    }
    int flag = 0, elem = -1;
    for (int i = 1; i <= m; i++) {
      if (amap[b[i]] >= 1) {
        flag = 1;
        elem = b[i];
        break;
      }
    }
    if (flag) {
      cout << "YES" << endl;
      cout << 1 << ' ' << elem << endl;
    } else
      cout << "NO" << endl;
  }
}
