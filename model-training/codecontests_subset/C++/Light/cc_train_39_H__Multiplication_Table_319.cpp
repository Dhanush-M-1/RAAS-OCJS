#include <bits/stdc++.h>
using namespace std;
struct node {
  int x, y, z;
};
int n;
int m, k;
int a[105], b[105];
string chuyen(int x) {
  string s;
  while (x > 0) {
    char c = x % n + '0';
    s = c + s;
    x /= n;
  }
  return s;
}
int main() {
  cin >> n;
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) {
      cout << chuyen(i * j) << " ";
    }
    cout << endl;
  }
  return 0;
}
