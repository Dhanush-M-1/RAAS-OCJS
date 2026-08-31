#include <bits/stdc++.h>
using namespace std;
long long int a[101], current = 0, no = 1;
long long int alloc(long long int n, long long int m) {
  long long int i = 0, flag = 0, start, count = 0;
  while (i < m) {
    start = i;
    while (a[i] == 0 && i < m && abs(i - start) < n + 1) {
      count++;
      i++;
    }
    if (count >= n) {
      flag = 1;
      break;
    } else {
      count = 0;
      i++;
    }
  }
  if (flag == 0) {
    return 0;
  } else {
    long long int j;
    for (j = start; j < n + start; j++) {
      a[j] = no;
    }
    no++;
    return no - 1;
  }
}
long long int erase(long long int n, long long int m) {
  long long int flag = 0;
  for (long long int i = 0; i < m; i++) {
    if (a[i] == n) flag = 1;
    if (a[i] == n) a[i] = 0;
  }
  return flag;
}
void defragment(long long int m) {
  long long int i = 0;
  long long int j = 0;
  while (i < m) {
    if (a[i] != 0) {
      a[j] = a[i];
      if (i != j) a[i] = 0;
      j++;
    }
    i++;
  }
  current = j;
}
int main() {
  string s, _;
  fill_n(a, 101, 0);
  long long int t, m;
  cin >> t >> m;
  getline(cin, _);
  while (t--) {
    getline(cin, s);
    if (s[0] == 'a') {
      long long int i = 6;
      long long int arg = 0;
      while (s[i] != '\0') {
        arg *= 10;
        arg += int(s[i]) - '0';
        i++;
      }
      long long int temp = alloc(arg, m);
      if (temp == 0)
        cout << "NULL\n";
      else
        cout << temp << "\n";
    } else if (s[0] == 'e') {
      long long int i = 6;
      long long int arg = 0;
      while (s[i] != '\0') {
        arg *= 10;
        arg += int(s[i]) - '0';
        i++;
      }
      if (erase(arg, m) == 0 || arg == 0) {
        cout << "ILLEGAL_ERASE_ARGUMENT\n";
      }
    } else {
      defragment(m);
    }
  }
  return 0;
}
