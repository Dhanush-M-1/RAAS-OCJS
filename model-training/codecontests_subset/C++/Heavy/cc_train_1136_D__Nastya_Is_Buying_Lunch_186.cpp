#include <bits/stdc++.h>
using namespace std;
void error(istream_iterator<string> _iterat) {}
template <typename T, typename... args>
void error(istream_iterator<string> _iterat, T a, args... arguments) {
  cerr << *_iterat << "=" << a << "\n";
  error(++_iterat, arguments...);
}
template <typename T, typename V>
void error(string pri, const pair<T, V> &z) {
  cerr << pri << "="
       << "{" << z.first << "," << z.second << "}"
       << "\n";
}
template <typename T, typename V>
void error(string pri, const map<T, V> &z) {
  cerr << pri << " is={";
  for (auto it = z.begin(); it != z.end(); ++it) {
    cerr << it->first << ":" << it->second;
    auto _it = z.end();
    _it--;
    if (it != _it) cerr << ",";
  }
  cerr << "}";
  cerr << "\n";
}
template <typename T>
void error(string pri, const vector<T> &z, long long st, long long ed) {
  cerr << pri << " in range[" << st << "," << ed << ")=[";
  for (long long i = st; i < ed; ++i) {
    cerr << z[i];
    if (i != ed - 1) cerr << " ";
  }
  cerr << "]";
  cerr << "\n";
}
template <typename T>
void error(string pri, const set<T> &z, long long st, long long ed) {
  cerr << pri << " in range[" << st << "," << ed << ")=[";
  long long tempcount = 0;
  for (auto it = z.begin(); it != z.end(); ++it) {
    if (tempcount >= st and tempcount < ed) {
      cerr << *it;
      if (tempcount != ed - 1) cerr << " ";
    }
    tempcount++;
  }
  cerr << "]";
  cerr << "\n";
}
template <typename T>
void error(string pri, const T z[], long long st, long long ed) {
  cerr << pri << " in range[" << st << "," << ed << ")=[";
  for (long long i = st; i < ed; ++i) {
    cerr << z[i];
    if (i != ed - 1) cerr << " ";
  }
  cerr << "]";
  cerr << "\n";
}
void logic() {
  int n, k;
  cin >> n >> k;
  int arr[n];
  int count = 0;
  for (int i = 0; i < n; ++i) {
    cin >> arr[i];
  }
  map<pair<int, int>, bool> m;
  int u, v;
  for (int i = 0; i < k; ++i) {
    cin >> u >> v;
    m[{u, v}] = 1;
  }
  set<int> s;
  s.insert(arr[n - 1]);
  for (int i = n - 2; i >= 0; --i) {
    int temp = arr[i];
    bool flag = 0;
    for (auto it = s.begin(); it != s.end(); ++it) {
      if (m[{temp, *it}] == 0) {
        flag = 1;
        break;
      }
    }
    if (flag == 0)
      count++;
    else
      s.insert(temp);
  }
  cout << count;
  cout << "\n";
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  long long t;
  { logic(); }
}
