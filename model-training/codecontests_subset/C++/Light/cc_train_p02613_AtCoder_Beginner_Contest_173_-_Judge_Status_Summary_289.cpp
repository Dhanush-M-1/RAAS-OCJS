#include<iostream>
using namespace std;
int main()
{
	int N;
	cin>>N;
	string num;
	string a[4]={"AC","WA","TLE","RE"};
	int m[4]={0};
	for(int i=0;i<N;i++)
	{
		cin>>num;
		for(int j=0;j<4;j++)
		if(num==a[j])
		m[j]++;
	}
	for(int i=0;i<4;i++)
	{
		cout<<a[i]<<" x "<<m[i]<<endl;
	}

 } 