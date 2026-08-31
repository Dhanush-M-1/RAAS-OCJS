#include "bits/stdc++.h"
using namespace std;

int a,b;

int main()
{
	cin>>a>>b;
	if(max(a,b)>9) cout<<-1;
	else cout<<a*b;
}