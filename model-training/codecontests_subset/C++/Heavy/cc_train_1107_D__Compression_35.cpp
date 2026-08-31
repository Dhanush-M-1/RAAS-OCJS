#include <bits/stdc++.h>
using namespace std;
long long int n;
void change(char ch, vector<int> &c);
void change(char ch, vector<int> &c) {
  long long int num;
  if ((int)(ch) >= 65) {
    num = (int)(ch)-55;
  } else {
    num = (int)(ch)-48;
  }
  long long int p = 3;
  while (num > 0) {
    long long int d = num % 2;
    num = num / 2;
    c[p--] = d;
  }
  for (int i = p; i >= 0; i--) {
    c[i] = 0;
  }
}
void convert(string s, vector<int> &d) {
  long long int p = 0;
  for (int i = 0; i < s.length(); i++) {
    vector<int> c(4, 0);
    change(s[i], c);
    long long int p1 = 0;
    for (int j = p; j < p + 4; j++) {
      d[j] = c[p1++];
    }
    p = p + 4;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> n;
  int a[n + 1][n + 1];
  for (int i = 0; i < n; i++) {
    vector<int> d(n, 0);
    string s;
    cin >> s;
    convert(s, d);
    for (int j = 0; j < n; j++) {
      a[i][j] = d[j];
    }
  }
  vector<vector<int> > rect(n + 1, vector<int>(n + 1, 0));
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      long long int s = 0;
      if (i >= 0 && j - 1 >= 0) {
        s += rect[i][j - 1];
      }
      if (i - 1 >= 0 && j >= 0) {
        s += rect[i - 1][j];
      }
      if (i - 1 >= 0 && j - 1 >= 0) {
        s -= rect[i - 1][j - 1];
      }
      s += a[i][j];
      rect[i][j] = s;
    }
  }
  vector<int> factor;
  for (int i = 1; i <= n; i++) {
    if (n % i == 0) {
      factor.push_back(i);
    }
  }
  sort(factor.begin(), factor.end());
  long long int ans = 1;
  long long int size = factor.size();
  for (int k = size - 1; k >= 0; k--) {
    long long int x = factor[k];
    long long int flag = 0;
    for (int i = 0; i < n; i += x) {
      for (int j = 0; j < n; j += x) {
        long long int s = 0;
        if (i + x - 1 < n && j + x - 1 < n) {
          s += rect[i + x - 1][j + x - 1];
        }
        if (i - 1 >= 0 && j - 1 >= 0) {
          s += rect[i - 1][j - 1];
        }
        if (i - 1 >= 0 && j + x - 1 < n) {
          s -= rect[i - 1][j + x - 1];
        }
        if (i + x - 1 < n && j - 1 >= 0) {
          s -= rect[i + x - 1][j - 1];
        }
        if (a[i][j] == 0) {
          if (s != 0) {
            flag = -1;
            break;
          }
        } else {
          if (s != x * x) {
            flag = -1;
            break;
          }
        }
      }
      if (flag == -1) {
        break;
      }
    }
    if (flag == 0) {
      ans = x;
      break;
    }
  }
  cout << ans << endl;
  return 0;
}
