#include <bits/stdc++.h>
using namespace std;
char mp[1000];
int add1[200];
int add2[200];
int a = 1, b = 0;
int n = 0;
int len;
bool slove() {
  if (a - 1 >= b) {
    if (a - 1 - n * b >= n) return false;
    for (int i = 0; i < a - 1; i++) add1[i] = 1;
    if (a - 1 - n * b >= 0) {
      add1[a - 1] = n + n * b + 1 - a;
      for (int i = 0; i < b; i++) add2[i] = n;
      return true;
    }
    add1[a - 1] = n;
    for (int i = 0; i < b; i++) add2[i] = 1;
    int num = a - 1 - b;
    for (int i = 0; i < b; i++)
      if (num >= n - 1)
        num -= n - 1, add2[i] = n;
      else {
        add2[i] = 1 + num;
        return true;
      }
  } else {
    for (int i = 0; i < b; i++) add2[i] = 1;
    for (int i = 0; i < a; i++) add1[i] = 1;
    int num = n + b - a;
    if (num < 0) return false;
    for (int i = 0; i < a; i++)
      if (num >= n - 1)
        num -= n - 1, add1[i] = n;
      else {
        add1[i] = 1 + num;
        return true;
      }
    if (num > 0) return false;
  }
}
bool prin() {
  printf("Possible\n");
  printf("%d", add1[0]);
  int c = 1, d = 0;
  for (int i = 1; i < len; i++)
    if (mp[i] == '+') {
      printf("+ %d", add1[c++]);
      i += 2;
    } else if (mp[i] == '-') {
      printf("- %d", add2[d++]);
      i += 2;
    } else
      printf("%c", mp[i]);
  printf("\n");
}
int main() {
  cin.getline(mp, 500);
  len = strlen(mp);
  int i = 0;
  for (; i < len; i++)
    if (mp[i] == '+')
      a++;
    else if (mp[i] == '-')
      b++;
    else if (mp[i] == '=')
      break;
  i += 2;
  for (; i < len; i++) n = n * 10 + mp[i] - '0';
  if (slove())
    prin();
  else
    printf("Impossible\n");
  return 0;
}
