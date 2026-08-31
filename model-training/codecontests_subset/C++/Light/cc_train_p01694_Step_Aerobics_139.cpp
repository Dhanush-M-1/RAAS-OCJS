#include <iostream>
#include <string>
using namespace std;
		   
int main()
{
	int n = 0;
	for (; cin >> n, n != 0;)
	{
		string s = ""; 
		int	sum = 0;
		int u = 0;
		for (int i = 0;i<n; i ++)
		{
			cin >> s;
			if (s[1] == 'u')u++;
			else if (s[1] == 'd')u--;
			if (u == 2 || u==-2)
			{
				sum++;
				u = 0;
			}
		}
		cout << sum << endl;
	}
	return 0;
}			