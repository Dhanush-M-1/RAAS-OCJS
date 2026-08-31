#include <bits/stdc++.h>
using namespace std;
long long ans, x;
long long fac(long long x) {
  if (x == 4)
    return 322;
  else if (x == 6)
    return 53;
  else if (x == 8)
    return 7222;
  else if (x == 9)
    return 7332;
  else
    return x;
}
int main() {
  vector<int> v;
  vector<int> v2;
  cin >> x;
  if (x != 10) {
    for (int i = 0; i < x; i++) {
      v.push_back(i);
    }
    int ct = x;
    for (int i = 1; ct < 100; i++, ct++) {
      int q = v[i] * 10;
      for (int j = 0; j < x; j++) v.push_back(q + j);
    }
    for (int i = 1; i < x; i++) {
      for (int j = 1; j < x; j++) {
        int a = i * j, b = 0;
        cout << v[i * j];
        cout << " ";
      }
      cout << "\n";
    }
  } else
    for (int i = 1; i < 10; i++) {
      for (int j = 1; j < 10; j++) cout << i * j << " ";
      cout << endl;
    }
}
