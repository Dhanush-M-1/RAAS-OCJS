#include <bits/stdc++.h>
using namespace std;
int n;
char two[2][11];
string first[1001];
string second[1001];
int main() {
  scanf("%s %s", two[0], two[1]);
  first[0] = string(two[0]);
  second[0] = string(two[1]);
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%s %s", two[0], two[1]);
    string f(two[0]);
    string s(two[1]);
    first[i + 1] = (first[i] == f ? second[i] : first[i]);
    second[i + 1] = s;
  }
  for (int i = 0; i <= n; i++) {
    cout << first[i] << " " << second[i] << endl;
  }
  return 0;
}
