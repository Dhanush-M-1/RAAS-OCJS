#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline void read(T& x) {
  x = 0;
  char c;
  while (!isdigit(c = getchar()))
    ;
  do {
    x = x * 10 + c - '0';
  } while (isdigit(c = getchar()));
}
template <typename T>
inline void write(T x) {
  if (x > 9) write(x / 10);
  putchar(x % 10 + 48);
}
void Write(string s) {
  for (int i = 0; i < s.length(); i++) {
    putchar(s[i]);
  }
}
void Sangnt(bool nt[], int n) {
  int x = sqrt(n);
  nt[0] = true, nt[1] = true;
  for (int i = 2; i <= x; i++) {
    if (nt[i] == false) {
      for (int j = i * i; j <= n; j += i) {
        nt[j] = true;
      }
    }
  }
}
void Congdon(int a[], int n) {
  for (int i = 1; i < n; i++) {
    a[i] += a[i - 1];
  }
}
unsigned long long POW(int a, int b) {
  if (b == 0) return 1;
  unsigned long long y = POW(a, b / 2);
  if (b % 2 == 0)
    return y * y;
  else
    return y * y * a;
}
long long UCLN(long long x, long long y) {
  long long r, a, b;
  a = max(x, y), b = min(x, y);
  while (b) {
    r = a % b;
    a = b, b = r;
  }
  return a;
}
string add(string a, string b) {
  string ans;
  while (a.length() < b.length()) a = '0' + a;
  while (b.length() < a.length()) b = '0' + b;
  ans = a;
  int n = ans.length();
  int digit, Add = 0;
  for (int i = n - 1; i >= 0; i--) {
    digit = (a[i] - '0' + b[i] - '0' + Add) % 10;
    Add = (a[i] - '0' + b[i] - '0' + Add) / 10;
    ans[i] = digit + '0';
  }
  if (Add == 1) ans = '1' + ans;
  while (ans[0] == '0' and ans.length() > 1) ans.erase(0, 1);
  return ans;
}
string Minu(string a, string b) {
  string ans;
  while (a.length() < b.length()) a = '0' + a;
  while (b.length() < a.length()) b = '0' + b;
  ans = a;
  int n = ans.length();
  int digit, Add = 0;
  for (int i = n - 1; i >= 0; i--) {
    digit = a[i] - b[i] - Add;
    if (digit < 0) {
      digit = digit + 10;
      Add = 1;
    } else
      Add = 0;
    ans[i] = digit + '0';
  }
  while (ans[0] == '0' and ans.length() > 1) ans.erase(0, 1);
  return ans;
}
double a, b, c, x, y;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
  cin >> a >> b >> c;
  if (a == 0) {
    if (b == 0) {
      if (c == 0) {
        cout << -1;
      } else {
        cout << 0;
      }
    } else {
      cout << 1 << endl;
      printf("%.10f", -c / b);
    }
  } else {
    double delta = b * b - 4 * a * c;
    if (delta == 0) {
      x = -b / 2 / a;
      cout << 1 << endl;
      printf("%.10f", x);
    } else if (delta < 0) {
      cout << 0;
    } else {
      cout << 2 << endl;
      x = -(b + sqrt(delta)) / 2 / a;
      y = -(b - sqrt(delta)) / 2 / a;
      if (x > y) {
        swap(x, y);
      }
      printf("%.10f\n", x);
      printf("%.10f", y);
    }
  }
  return 0;
}
