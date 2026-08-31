#include <bits/stdc++.h>
using namespace std;
int main() {
  char r[55];
  int y = 0;
  scanf("%s", r);
  scanf("%d", &y);
  for (int i = 0; r[i] != '\0'; i++) {
    if (tolower(r[i]) < y + 97) {
      r[i] = toupper(r[i]);
    } else
      r[i] = tolower(r[i]);
  }
  cout << r << endl;
  return 0;
}
