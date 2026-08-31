// Просто решаю.cpp : Этот файл содержит функцию "main". Здесь начинается и заканчивается выполнение программы.
//

//KiruxaLight
#define _CRT_SECURE_NO_WARNINGS
#define _USE_MATH_DEFINES
#include <iostream>
#include <vector>
#include <string>
#include <set>
#include <map>
#include <algorithm>
#include <utility>
#include <cmath>
#include <iomanip>
#include <stack>
#include <deque>
#include <queue>
#include <cstdio>
#include <unordered_map>
#include <unordered_set>
#include <numeric>
#include <cassert>
#include <bitset>
using namespace std;
#define int long long
#define all(a) a.begin(), a.end()
#define rall(a) a.rbegin(), a.rend()
const int INF = 1e9 + 123, MAXN = 2e5, MEGAINF = 1e18, C = 50;
const int mod = 1e9 + 7;
int dp[10][MAXN + 1];
void init()
{
  for (int i = 0; i < 10; ++i)
    dp[i][0] = 1;
  for (int i = 1; i <= MAXN; ++i)
  {
    for (int j = 0; j < 9; ++j)
      dp[j][i] = dp[j + 1][i - 1];
    dp[9][i] = (dp[1][i - 1] + dp[0][i - 1]) % mod;
  }
}
signed main()
{
  setlocale(LC_ALL, "rus");

  /*freopen(".in", "r", stdin);
  freopen(".out", "w", stdout);*/

  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  init();
  /*for (int i = 0; i <= MAXN; ++i, cout << endl)
    for (int j = 0; j < 10; ++j)
      cout << dp[j][i] << " ";*/
  int t;
  cin >> t;
  while (t--)
  {
    int n, m;
    cin >> n >> m;
    int ans = 0;
    while (n)
    {
      ans = (ans + dp[n % 10][m]) % mod;
      n /= 10;
    }
    cout << ans << "\n";
  }
}
// Запуск программы: CTRL+F5 или меню "Отладка" > "Запуск без отладки"
// Отладка программы: F5 или меню "Отладка" > "Запустить отладку"

// Советы по началу работы
//   1. В окне обозревателя решений можно добавлять файлы и управлять ими.
//   2. В окне Team Explorer можно подключиться к системе управления версиями.
//   3. В окне "Выходные данные" можно просматривать выходные данные сборки и другие сообщения.
//   4. В окне "Список ошибок" можно просматривать ошибки.
//   5. Последовательно выберите пункты меню "Проект" > "Добавить новый элемент", чтобы создать файлы кода, или "Проект" > "Добавить существующий элемент", чтобы добавить в проект существующие файлы кода.
//   6. Чтобы снова открыть этот проект позже, выберите пункты меню "Файл" > "Открыть" > "Проект" и выберите SLN-файл.
