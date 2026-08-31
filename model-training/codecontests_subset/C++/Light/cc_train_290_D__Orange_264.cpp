#include <bits/stdc++.h>
using namespace std;
char ar[1000], er[1000];
void oku() {
  int i, t, a;
  scanf("%s", ar);
  scanf("%d", &t);
  a = strlen(ar);
  for (int i = 0; i < a; i++)
    if (ar[i] <= 'Z') ar[i] += 32;
  for (int i = 0; i < a; i++) {
    if (ar[i] < 97 + t) ar[i] = ar[i] - 32;
  }
  cout << ar << endl;
}
int main() {
  oku();
  return 0;
}
