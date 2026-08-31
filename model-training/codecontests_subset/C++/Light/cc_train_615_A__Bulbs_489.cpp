#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  set<int> s;
  while (n--) {
    int a;
    cin >> a;
    int arr[a];
    for (int i = 0; i < a; i++) {
      int x;
      cin >> x;
      arr[i] = x;
      s.insert(arr[i]);
    }
  }
  if (s.size() == m) {
    cout << "YES" << endl;
  } else {
    cout << "NO" << endl;
  }
}
