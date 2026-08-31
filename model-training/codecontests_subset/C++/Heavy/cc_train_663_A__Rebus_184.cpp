#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  string s;
  getline(cin, s);
  long long ok = 0;
  long long plus = 0, minus = 0;
  vector<long long> digit;
  for (char c : s) {
    if (c == '?') {
      if (!ok)
        plus++;
      else
        minus++;
    } else if (c == '+' || c == '-') {
      if (c == '+')
        ok = 0;
      else
        ok = 1;
    } else if (c >= '0' && c <= '9') {
      digit.push_back(c - '0');
    }
  }
  long long num = 0, mul = 1;
  for (long long i = digit.size() - 1; i >= 0; i--) {
    num += (mul * digit[i]);
    mul = mul * 10;
  }
  if (plus == minus) {
    if (plus == 1 || num == 1) {
      cout << "Impossible"
           << "\n";
      return 0;
    }
    cout << "Possible"
         << "\n";
    int first = 0;
    ok = 0;
    for (char c : s) {
      if (c == '?') {
        if (!ok) {
          if (!first) {
            cout << num;
            first = 1;
          } else if (first == 1) {
            cout << 2;
            first = 2;
          } else {
            cout << 1;
          }
        } else {
          cout << 1;
        }
      } else {
        if (c == '-') ok = 1;
        if (c == '+') ok = 0;
        cout << c;
      }
    }
    cout << "\n";
    return 0;
  } else if (plus > minus) {
    long long now = num + (minus * num), sum = 0;
    vector<long long> tot;
    if (now / plus == 0 || now / plus > num) {
      cout << "Impossible"
           << "\n";
      return 0;
    }
    cout << "Possible"
         << "\n";
    for (int i = 0; i < plus; i++) tot.push_back(0);
    int idx = 0;
    while (now--) {
      tot[idx]++;
      idx++;
      if (idx == plus) idx = 0;
    }
    for (int i = 0; i < plus; i++) {
      if (tot[i] > num) {
        cout << "Impossible"
             << "\n";
        return 0;
      }
    }
    ok = 0;
    idx = 0;
    for (char c : s) {
      if (c == '?') {
        if (!ok) {
          cout << tot[idx];
          idx++;
        } else {
          cout << num;
        }
      } else {
        if (c == '+') ok = 0;
        if (c == '-') ok = 1;
        cout << c;
      }
    }
    cout << "\n";
    return 0;
  } else {
    long long now = (plus - 1) * num, sum = 0;
    vector<long long> tot;
    if (now / minus == 0) {
      cout << "Impossible"
           << "\n";
      return 0;
    }
    cout << "Possible"
         << "\n";
    for (int i = 0; i < minus; i++) tot.push_back(0LL);
    int idx = 0;
    while (now--) {
      tot[idx]++;
      idx++;
      if (idx == minus) idx = 0;
    }
    for (int i = 0; i < minus; i++) {
      if (tot[i] > num) {
        cout << "Impossible"
             << "\n";
        return 0;
      }
    }
    ok = 0;
    idx = 0;
    for (char c : s) {
      if (c == '?') {
        if (!ok) {
          cout << num;
        } else {
          cout << tot[idx];
          idx++;
        }
      } else {
        if (c == '+') ok = 0;
        if (c == '-') ok = 1;
        cout << c;
      }
    }
    cout << "\n";
    return 0;
  }
}
