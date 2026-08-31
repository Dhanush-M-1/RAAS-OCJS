#include<iostream>
#include<algorithm>
using namespace std;

int main()
{
	int num;
	cin >> num;
	int* T = new int[num];
	for (int i = 0; i < num; i++)
	{
		cin >> T[i];
	}
	int num1=0;
	for(int i=0;i<num;i++)
	{
		int mini = i;
		for(int j=i+1;j<num;j++)
		{
			if(T[j]<T[mini])
				mini = j;
		}
		if(mini!=i)
		{
			swap(T[i], T[mini]);
			num1++;
		}
	}
	for (int j = 0; j < num; j++)
	{
		cout << T[j] << (j == num - 1 ? '\n' : ' ');
	}
	cout << num1 << endl;
}
