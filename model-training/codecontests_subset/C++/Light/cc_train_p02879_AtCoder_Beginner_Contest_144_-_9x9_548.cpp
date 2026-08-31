#include <bits/stdc++.h>
using namespace std;

int main() 
{
	int N,M;
	cin>>M>>N;
	if(N<=9&&M<=9)
	    cout<<N*M;
    else
        cout<<-1;
}