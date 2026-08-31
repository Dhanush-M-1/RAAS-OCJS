#include<iostream>
using namespace std;



//配列の要素数
//#define MAX	1000000
#define MAX	100000

int h_input[MAX] = {0};


int main(void)
{
	//入力変数
	int n = 0;

	while (true)
	{
		cin >> n;
		if (n == 0)	{	return 0;	}

		for (int i = 0; i < n; i++)
		{
			cin >> h_input[i];
		}

		//カウント変数
		int count = 0;

		for (int i = n - 1; i >= 0; i--)
		{
			for (int j = 1; j <= i; j++)
			{
				if (h_input[j - 1] > h_input[j])
				{
					int tmp = h_input[j];
					h_input[j] = h_input[j - 1];
					h_input[j - 1] = tmp;

					count++;
				}
			}
		}

		cout << count << endl;
	}

	return 0;
}