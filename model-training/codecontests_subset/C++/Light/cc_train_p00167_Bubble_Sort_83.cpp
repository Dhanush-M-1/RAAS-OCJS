#include<stdio.h>
#include<iostream>
#include<string>
#include<cstdlib>
#include <vector>
#include <algorithm>
#include <functional>
#include <utility> 

using namespace std;

int main()
{
	while (1)
 { 
	int n, k;
	k = 0;
	vector<int> A;
	cin >> n;
	if (n==0)
	{
		break;
	}
	for (int i = 0; i < n; i++)
	{
		int a;
		cin >> a;
		A.push_back(a);
	}
	for (int j = 0; j < n;j++)
	{
		for (int i = 0; i < n-1; i++)
		{
			if (A[i]>A[i + 1])
			{
				swap(A[i], A[i + 1]);
				k++;
			}
		}
	}
	cout << k << endl;
 }
	return 0;
}