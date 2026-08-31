#include <bits/stdc++.h>
using namespace std;

int main() {
  int n;
  scanf("%d", &n);
  map<string, int> c;
  for(int i = 0; i < n; i++) {
    string s;
    cin >> s;
    c[s]++;
  }
  printf("AC x %d\n", c["AC"]);
  printf("WA x %d\n", c["WA"]);
  printf("TLE x %d\n", c["TLE"]);
  printf("RE x %d\n", c["RE"]);
}