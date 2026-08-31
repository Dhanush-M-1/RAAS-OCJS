#include <bits/stdc++.h>
using namespace std;
int Days(int Month) {
  if (Month == 2) return 28;
  if (Month == 4 || Month == 6 || Month == 9 || Month == 11) return 30;
  return 31;
}
int Calc(string S) {
  if (S[2] != '-' || S[5] != '-') return -1;
  for (int i = 0; i < 10; i++) {
    if (i == 2 || i == 5) continue;
    if (S[i] < '0' || S[i] > '9') return -1;
  }
  int Day = (S[0] - 48) * 10 + (S[1] - 48);
  int Month = (S[3] - 48) * 10 + (S[4] - 48);
  int Year =
      (S[6] - 48) * 1000 + (S[7] - 48) * 100 + (S[8] - 48) * 10 + (S[9] - 48);
  if (Year < 2013 || Year > 2015) return -1;
  if (Month < 1 || Month > 12) return -1;
  if (Day < 1 || Day > Days(Month)) return -1;
  return (Year - 2013) * 10000 + Month * 100 + Day;
}
void Output(int X) {
  putchar(X / 10 + 48);
  putchar(X % 10 + 48);
}
int main() {
  string S;
  cin >> S;
  static int Count[30000];
  memset(Count, 0, sizeof(Count));
  for (int i = 0; i + 10 <= S.size(); i++) {
    string T = "";
    for (int j = 0; j < 10; j++) T += S[i + j];
    int Temp = Calc(T);
    if (Temp != -1) Count[Temp]++;
  }
  int Ans = 0;
  for (int i = 1; i < 30000; i++)
    if (Count[i] > Count[Ans]) Ans = i;
  Output(Ans % 100);
  putchar('-');
  Output(Ans / 100 % 100);
  putchar('-');
  printf("%d\n", Ans / 10000 + 2013);
  return 0;
}
