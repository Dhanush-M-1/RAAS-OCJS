#include <bits/stdc++.h>
using namespace std;
int main() {
  int teams;
  int host_uniforms[50];
  int guest_uniforms[50];
  scanf("%d", &teams);
  for (int i = 0; i < teams; i++) {
    scanf("%d %d", &host_uniforms[i], &guest_uniforms[i]);
  }
  int htwgu = 0;
  for (int i = 0; i < teams; i++) {
    for (int j = 0; j < teams; j++)
      if (host_uniforms[i] == guest_uniforms[j]) {
        htwgu++;
      }
  }
  cout << htwgu << endl;
  return 0;
}
