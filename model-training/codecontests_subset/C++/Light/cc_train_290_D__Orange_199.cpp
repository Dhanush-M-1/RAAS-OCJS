#include <bits/stdc++.h>
using namespace std;
bool comp(int a, int b) { return (a > b); }
int main() {
  int n, x;
  char data[100];
  scanf("%s %d", &data, &n);
  x = strlen(data);
  for (int i = 0; i <= x - 1; i++) {
    if (data[i] >= 'A' && data[i] <= 'Z') data[i] = data[i] - 'A' + 'a';
    if (data[i] < n + 97) data[i] = data[i] - 'a' + 'A';
  }
  printf("%s", data);
  return 0;
}
