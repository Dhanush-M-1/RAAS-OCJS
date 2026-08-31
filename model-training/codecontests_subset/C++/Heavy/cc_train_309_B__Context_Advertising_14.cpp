#include <bits/stdc++.h>
using namespace std;
void Get(int &T) {
  char C;
  bool F = 0;
  for (; C = getchar(), C < '0' || C > '9';)
    if (C == '-') F = 1;
  for (T = C - '0'; C = getchar(), C >= '0' && C <= '9'; T = T * 10 + C - '0')
    ;
  F && (T = -T);
}
int Len[1000005];
char S[5000005];
int Begin[5000005];
int N, R, C;
int End[1000005];
int REnd[1000005];
void Init() {
  Get(N);
  Get(R);
  Get(C);
  C++;
  for (int i = 1; i <= N; i++) {
    scanf("%s", S + Begin[i]);
    Len[i] = strlen(S + Begin[i]);
    Begin[i + 1] = Begin[i] + Len[i];
  }
}
int Ans = 1;
void Work() {
  Len[N + 1] = -1;
  for (int j = N, i = N + 1, k = 0; i >= 1; i--) {
    k += Len[i] + 1;
    for (; k > C; j--) k -= Len[j] + 1;
    End[i] = j;
  }
  for (int k = 1; k <= N + 1; k++) REnd[k] = k - 1;
  for (int X = R; X; X >>= 1) {
    if (X & 1) {
      for (int i = 1; i <= N + 1; i++) REnd[i] = End[REnd[i] + 1];
    }
    for (int i = 1; i <= N + 1; i++) End[i] = End[End[i] + 1];
  }
  Ans = 1;
  for (int k = 1; k <= N; k++)
    if (REnd[Ans] - Ans < REnd[k] - k) Ans = k;
}
void Output() {
  for (int i = Ans, k = 0, first = 1; i <= REnd[Ans]; i++) {
    k += Len[i] + 1;
    if (k > C) {
      k = Len[i] + 1;
      puts("");
      first = 1;
    }
    if (first)
      first = 0;
    else
      printf(" ");
    for (int k = Begin[i]; k < Begin[i + 1]; k++) printf("%c", S[k]);
  }
  puts("");
}
int main() {
  Init();
  Work();
  Output();
  return 0;
}
