#include <bits/stdc++.h>
using namespace std;
template <class T>
void print(T &x) {
  for (auto &it : x) {
    cout << it << " ";
  }
  cout << "\n";
};
void solve();
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  solve();
}
void solve() {
  int n;
  cin >> n;
  multiset<int> st1, st2;
  for (int i = 0; i < (n); ++i) {
    int tmp;
    cin >> tmp;
    st1.insert(tmp);
  }
  for (int i = 0; i < (n - 1); ++i) {
    int tmp;
    cin >> tmp;
    st2.insert(tmp);
    auto it = st1.lower_bound(tmp);
    st1.erase(it);
  }
  print(st1);
  for (int i = 0; i < (n - 2); ++i) {
    int tmp;
    cin >> tmp;
    auto it = st2.lower_bound(tmp);
    st2.erase(it);
  }
  print(st2);
}
