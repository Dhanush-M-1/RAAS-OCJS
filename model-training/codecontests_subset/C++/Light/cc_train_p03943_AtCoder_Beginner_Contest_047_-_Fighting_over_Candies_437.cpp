#include<iostream>

using namespace std;

int main(void)
{
	int a,b,c;
	cin >> a >> b >> c;
	cout << (a==b+c ? "Yes":(b==a+c ? "Yes":(c==a+b ? "Yes":"No"))) << endl;
}