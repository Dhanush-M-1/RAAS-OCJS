#include <bits/stdc++.h>
using namespace std;
int main()
{
	int A,B;
	cin>>A>>B;
	printf("%d",(A>9|B>9)?-1:A*B);
}