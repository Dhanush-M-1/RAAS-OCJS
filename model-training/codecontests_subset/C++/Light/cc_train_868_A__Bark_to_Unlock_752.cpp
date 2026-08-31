#include <bits/stdc++.h>
using namespace std;
void file_i_o() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
int main() {
  string pass;
  cin >> pass;
  int n;
  scanf("%d", &n);
  string a;
  bool left = false;
  bool right = false;
  bool same = false;
  for (int i = (0); i < (n); i++) {
    cin >> a;
    if (a == pass) {
      same = true;
    }
    if (pass[0] == a[1]) left = true;
    if (pass[1] == a[0]) right = true;
  }
  if (left and right)
    printf("%s \n", "YES");
  else if (same)
    printf("%s \n", "YES");
  else
    printf("%s \n", "NO");
  return 0;
}
