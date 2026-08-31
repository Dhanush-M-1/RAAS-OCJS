import sys

# Input Helpers
def check_int(s):
    if s[0] in ('-', '+'):
      return s[1:].isdigit()
    return s.isdigit()

def check_float(s):
    try: 
        float(s)
        return True
    except ValueError:
        return False

def read_line():
  line = sys.stdin.readline().rstrip('\n')
  return line

def read_seq(sep=' ', convert_type=False):
  line = read_line()
  seq = line.split(sep)

  if convert_type == False:
    return seq
  else:
    seq_t=[]
    for i in range(0, len(seq)):
      if check_int(seq[i]):
        seq_t.append(int(seq[i]))
      elif check_float(seq[i]):
        seq_t.append(float(seq[i]))
      else:
        seq_t.append(seq[i])
    return seq_t

def read_value(type="string"):
  seq=read_seq()
  assert len(seq) == 1
  if type == "int":
    return int(seq[0])
  elif type == "float":
    return float(seq[0])
  return seq[0]

############################ MAIN ##############################################
seq=read_seq('+', False)
seq.sort()
print('+'.join(seq))

