#include <bits/stdc++.h>
using namespace std;
int main(void) {
  int a, b, c;
  scanf("%d %d %d", &a, &b, &c);
  float t = (a * c - c * b) / (float)b;
  if ((int)t == t)
    cout << (int)t << endl;
  else
    cout << (int)(t + 1) << endl;
  return 0;
}
