#include <bits/stdc++.h>
using namespace std;
struct Errors {
  vector<int> first;
  vector<int> second;
  vector<int> third;
  Errors(const int& numberOfFirstErrors)
      : first(numberOfFirstErrors),
        second(numberOfFirstErrors - 1),
        third(numberOfFirstErrors - 2) {}
};
void InputSingleErrorLine(vector<int>& error) {
  for (auto& i : error) {
    cin >> i;
  }
}
Errors Input() {
  size_t numberOfErrors;
  cin >> numberOfErrors;
  Errors error(numberOfErrors);
  InputSingleErrorLine(error.first);
  InputSingleErrorLine(error.second);
  InputSingleErrorLine(error.third);
  return move(error);
}
unsigned long long SumErrorsInSingleLine(const vector<int>& errors) {
  unsigned long long sum = 0;
  for (auto&& i : errors) {
    sum += i;
  }
  return sum;
}
vector<unsigned long long> SaveFixedErros(const Errors& error) {
  unsigned long long sumErrorsFirstLine = SumErrorsInSingleLine(error.first);
  unsigned long long sumErrorsSecondLine = SumErrorsInSingleLine(error.second);
  unsigned long long sumErrorsThirdLine = SumErrorsInSingleLine(error.third);
  vector<unsigned long long> fixedErrors = {
      sumErrorsFirstLine - sumErrorsSecondLine,
      sumErrorsSecondLine - sumErrorsThirdLine};
  return move(fixedErrors);
}
void PrintFixedErrors(const vector<unsigned long long>& errors) {
  for (auto&& i : errors) {
    cout << i << endl;
  }
}
int main() {
  Errors error = Input();
  vector<unsigned long long> fixedErrors = SaveFixedErros(error);
  PrintFixedErrors(fixedErrors);
  return EXIT_SUCCESS;
}
