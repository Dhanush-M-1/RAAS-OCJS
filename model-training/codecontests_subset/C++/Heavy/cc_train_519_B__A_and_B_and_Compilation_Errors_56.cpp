#include <bits/stdc++.h>
using namespace std;
int comp(const void *a, const void *b) { return *(int *)a - *(int *)b; }
int main() {
  int error;
  cin >> error;
  int *number = (int *)malloc(sizeof(int) * error);
  int *number1 = (int *)malloc(sizeof(int) * error - 1);
  int *number2 = (int *)malloc(sizeof(int) * error - 2);
  for (int i = 0; i < error; i++) cin >> number[i];
  qsort(number, error, sizeof(int), comp);
  for (int i = 0; i < error - 1; i++) cin >> number1[i];
  qsort(number1, error - 1, sizeof(int), comp);
  for (int i = 0; i < error - 2; i++) cin >> number2[i];
  qsort(number2, error - 2, sizeof(int), comp);
  int error1, error2;
  for (int i = 0; i < error; i++)
    if (number[i] != number1[i]) {
      error1 = number[i];
      break;
    }
  for (int i = 0; i < error - 1; i++)
    if (number1[i] != number2[i]) {
      error2 = number1[i];
      break;
    }
  cout << error1 << endl << error2 << endl;
  return 0;
}
