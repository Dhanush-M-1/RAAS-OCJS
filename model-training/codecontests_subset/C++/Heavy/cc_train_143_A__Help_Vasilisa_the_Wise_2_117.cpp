#include <bits/stdc++.h>
using namespace std;
bool prime(int x) {
  if (x == 1)
    return false;
  else if (x == 2)
    return true;
  for (int i = 2; i * i <= x; i++) {
    if (x % i == 0) return false;
  }
  return true;
}
void fun2(int t) {
  if (t == 1) {
    cout << "*";
    return;
  }
  cout << "*";
  return fun2(t - 1);
}
void fun(int s) {
  map<int, int> asd;
  map<int, int>::iterator ir;
  ir = asd.begin();
  ir->first;
  if (s) {
    cout << s % 10 << endl;
    fun(s / 10);
  }
}
long long numb(long long i) {
  if (i == 2 || i == 1)
    return 1;
  else {
    long long n = i, z = 0;
    while (n > 1) {
      if (i % n == 0) {
        z++;
      }
      n--;
    }
    return z;
  }
}
int main() {
  std::ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  vector<vector<int>> v(2, vector<int>(2));
  v[0][0] = (r1 - c2 + d1) / 2;
  v[0][1] = r1 - v[0][0];
  v[1][0] = c1 - v[0][0];
  v[1][1] = d1 - v[0][0];
  bool b = true;
  for (int i = 0; i < 2; i++) {
    for (int j = 0; j < 2; j++) {
      for (int h = 0; h < 2; h++) {
        for (int g = 0; g < 2; g++) {
          if (i == h && j == g) continue;
          if (v[i][j] == v[h][g]) {
            b = false;
          }
        }
      }
    }
  }
  for (int i = 0; i < 2; i++) {
    for (int j = 0; j < 2; j++) {
      if (v[i][j] == 0 || v[i][j] > 9) b = false;
    }
  }
  if (r1 != v[0][0] + v[0][1] || r2 != v[1][0] + v[1][1] ||
      c1 != v[0][0] + v[1][0] || c2 != v[0][1] + v[1][1] ||
      d1 != v[0][0] + v[1][1] || d2 != v[0][1] + v[1][0])
    b = false;
  if (b) {
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        cout << v[i][j] << " ";
      }
      cout << endl;
    }
  } else {
    cout << -1 << endl;
  }
  return 0;
}
