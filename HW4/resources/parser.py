#!/usr/bin/env python3
import re
print([re.findall(r'(\d+) (\d+)', line)
        for line in open('input-2.1.txt') if len(line)>3])
