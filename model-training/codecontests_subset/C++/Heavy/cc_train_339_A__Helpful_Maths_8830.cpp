#include <bits/stdc++.h>
using namespace std;
const long long int MOD = 1e9 + 7;
const int N = 1e4 + 10;
const int V = 1e5;
const long long int E = 4LL * V * V;
int Count[4];
int main() {
  string s;
  cin >> s;
  int n = s.size();
  for (int i = 0; i < (n); ++i) {
    Count[s[i] - '0']++;
    i++;
  }
  if (Count[1] > 0) {
    printf("1");
    Count[1]--;
  } else {
    if (Count[2] > 0) {
      printf("2");
      Count[2]--;
    } else {
      Count[3]--;
      printf("3");
    }
  }
  for (int i = 0; i < (Count[1]); ++i) {
    printf("+1");
  }
  for (int i = 0; i < (Count[2]); ++i) {
    printf("+2");
  }
  for (int i = 0; i < (Count[3]); ++i) {
    printf("+3");
  }
  printf("\n");
  return 0;
}
