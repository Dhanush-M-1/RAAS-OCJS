#include <bits/stdc++.h>
using namespace std;
int sum_of_digits(int num) {
  int sum = 0;
  while (num) {
    sum += num % 10;
    num = num / 10;
  }
  return sum;
}
int main() {
  string a = "123";
  string str;
  cin >> str;
  for (int i = 0; i < str.length(); i += 2) {
    int min = i;
    for (int j = i + 2; j < str.length(); j += 2) {
      if (str[j] < str[min]) min = j;
    }
    char temp = str[min];
    str[min] = str[i];
    str[i] = temp;
  }
  cout << str;
  return 0;
}
