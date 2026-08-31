#include<iostream>
using namespace std;

int main()
{
  const char sort_list[5] = "SHCD";
  int n;
  char sort;
  int num;
  bool card[4][13] = { false };

  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> sort >> num;
    for (int i = 0; i < 4; i++) 
      if (sort == sort_list[i]) card[i][num-1] = true;
  }
  for (int i = 0; i < 4; i++)
    for (int j = 0; j < 13; j++)
      if (!card[i][j]) cout << sort_list[i] << " " << j+1 << endl;

  return 0;
}
