#include <bits/stdc++.h>
using namespace std;
char r;
long long l, add = 1, give = 0;
int main() {
  vector<char> indecator;
  while (r != '=') {
    cin >> r;
    if (r == '+') {
      add++;
      indecator.push_back('+');
    } else if (r == '-') {
      give++;
      indecator.push_back('-');
    }
  }
  cin >> l;
  vector<long long> adds(add);
  vector<long long> gives(give);
  for (int i = 0; i < add; i++) {
    adds[i] = l;
  }
  for (int j = 0; j < give; j++) {
    gives[j] = l;
  }
  long long SUM = l * (add - give);
  if (SUM >= l) {
    int i = 0;
    long long test = SUM - l;
    while (test != 0 && i != add) {
      if (test - l >= -1) {
        adds[i++] = 1;
        test = test - l + 1;
      } else {
        adds[i] = adds[i++] - test;
        test = 0;
      }
    }
    if (test == 0) {
      cout << "Possible\n";
      int a = 0, b = 0;
      cout << adds[a++] << ' ';
      for (auto it = indecator.begin(); it != indecator.end(); it++) {
        if (*it == '+') {
          cout << "+ " << adds[a++] << ' ';
        } else {
          cout << "- " << gives[b++] << ' ';
        }
      }
      cout << "= " << l;
      return 0;
    } else {
      cout << "Impossible\n";
    }
  } else {
    int i = 0;
    long long test = l - SUM;
    while (test != 0 && i != give) {
      if (test - l >= -1) {
        gives[i++] = 1;
        test = test - l + 1;
      } else {
        gives[i] = gives[i++] - test;
        test = 0;
      }
    }
    if (test == 0) {
      cout << "Possible\n";
      int a = 0, b = 0;
      cout << adds[a++] << ' ';
      for (auto it = indecator.begin(); it != indecator.end(); it++) {
        if (*it == '+') {
          cout << "+ " << adds[a++] << ' ';
        } else {
          cout << "- " << gives[b++] << ' ';
        }
      }
      cout << "= " << l;
      return 0;
    } else {
      cout << "Impossible\n";
    }
  }
  return 0;
}
